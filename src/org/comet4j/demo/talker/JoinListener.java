package org.comet4j.demo.talker;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.comet4j.core.CometConnection;
import org.comet4j.core.CometEngine;
import org.comet4j.core.event.ConnectEvent;
import org.comet4j.core.listener.ConnectListener;
import org.comet4j.demo.talker.dto.JoinDTO;

/**
 * @description JoinListener
 * @author 不了了之之了之
 * @data 2013-5-29
 */
public class JoinListener extends ConnectListener {
	public boolean handleEvent(ConnectEvent anEvent) {
		CometConnection conn = anEvent.getConn();
		HttpServletRequest request = conn.getRequest();
		String userName = getCookieValue(request.getCookies(), "userName", "");
		try {
			userName = URLDecoder.decode(userName, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		JoinDTO dto = new JoinDTO(conn.getId(), userName);
		AppStore.getInstance().put(conn.getId(), userName);
		((CometEngine) anEvent.getTarget()).sendToAll("talker", dto);
		return true;
	}

	public String getCookieValue(Cookie[] cookies, String cookieName,
			String defaultValue) {
		String result = defaultValue;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cookieName.equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return result;
	}
}