package com.spring.board.configuration;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

public class WSHttpSessionConfiguration extends Configurator{

   @Override
   public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
      HttpSession hSession = (HttpSession)request.getHttpSession();
      System.out.println(hSession.getAttribute("data"));
      sec.getUserProperties().put("hSession", hSession);    // getUserProperties() : 사용자 정의
      super.modifyHandshake(sec, request, response);
   }

}
