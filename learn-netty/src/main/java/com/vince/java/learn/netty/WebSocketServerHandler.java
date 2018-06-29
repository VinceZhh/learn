package com.vince.java.learn.netty;

import org.jboss.netty.channel.*;
import org.jboss.netty.handler.codec.http.HttpRequest;
import org.jboss.netty.handler.codec.http.websocketx.*;

import java.util.Iterator;
import static org.jboss.netty.handler.codec.http.HttpHeaders.Names.*;
/**
 * Create by zhanghao12@jd.com on 2018/6/15
 */
public class WebSocketServerHandler extends SimpleChannelUpstreamHandler {
    private static final String WEBSOCKET_PATH = "/websocket";
    private WebSocketServerHandshaker handshaker;
    @Override
    public void channelOpen(ChannelHandlerContext ctx, ChannelStateEvent e)
            throws Exception {
        Globle.ctxs.add(ctx.getChannel());
        System.out.println(ctx.getChannel()+"s");
    }
    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e)
            throws Exception {
        Globle.ctxs.remove(ctx.getChannel());
    }
    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        Object msg = e.getMessage();
        String receivedMsg = msg.toString();
        receivedMsg = receivedMsg.substring(receivedMsg.indexOf('(')+1, receivedMsg.indexOf(')'));
        String[] RealMsg = receivedMsg.split(":");
        if(!RealMsg[1].trim().equals("")){
            if (msg instanceof HttpRequest) {
                handleHttpRequest(ctx, (HttpRequest) msg);
            } else if (msg instanceof WebSocketFrame) {
                Iterator<Channel> MyCtx = Globle.ctxs.iterator();
                while(MyCtx.hasNext()){
                    MyCtx.next().write(new TextWebSocketFrame(RealMsg[1]));
                }
                handleWebSocketFrame(ctx, (WebSocketFrame) msg);
            }
        }
    }
    private void handleHttpRequest(ChannelHandlerContext ctx, HttpRequest req) throws Exception {
        WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(
                getWebSocketLocation(req), null, false);
        handshaker = wsFactory.newHandshaker(req);
        if (handshaker == null) {
            wsFactory.sendUnsupportedWebSocketVersionResponse(ctx.getChannel());
        } else {
            handshaker.handshake(ctx.getChannel(), req).addListener(WebSocketServerHandshaker.HANDSHAKE_LISTENER);
        }
        WebSocketServer.ctx = ctx;
    }
    private void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
        // Check for closing frame
        if (frame instanceof CloseWebSocketFrame) {
            handshaker.close(ctx.getChannel(), (CloseWebSocketFrame) frame);

            WebSocketServer.ctx = null;
            return;
        }
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        e.getCause().printStackTrace();
        e.getChannel().close();
        WebSocketServer.ctx = null;
    }

    private static String getWebSocketLocation(HttpRequest req) {
        return "ws://" + req.getHeader(HOST) + WEBSOCKET_PATH;
    }
}
