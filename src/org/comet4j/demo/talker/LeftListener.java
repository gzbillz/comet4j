package org.comet4j.demo.talker;

import org.comet4j.core.CometConnection;
import org.comet4j.core.CometEngine;
import org.comet4j.core.event.DropEvent;
import org.comet4j.core.listener.DropListener;
import org.comet4j.demo.talker.dto.LeftDTO;

/**
 * @description LeftListener
 * @author 不了了之之了之
 * @data 2013-5-29
 */
public class LeftListener extends DropListener {
	public boolean handleEvent(DropEvent anEvent) {
		CometConnection conn = anEvent.getConn();
		if (conn != null) {
			String userName = AppStore.getInstance().get(conn.getId());
			LeftDTO dto = new LeftDTO(conn.getId(), userName);
			AppStore.getInstance().getMap().remove(conn.getId());
			((CometEngine) anEvent.getTarget()).sendToAll("talker", dto);
		}
		return true;
	}
}