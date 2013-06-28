package org.comet4j.demo.talker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.comet4j.core.CometContext;
import org.comet4j.core.CometEngine;
import org.comet4j.core.util.JSONUtil;
import org.comet4j.demo.talker.dto.RenameDTO;
import org.comet4j.demo.talker.dto.TalkDTO;
import org.comet4j.demo.talker.dto.UserDTO;

/**
 * @description WebServlet
 * @author 不了了之之了之
 * @data 2013-5-29
 */
public class WebServlet extends HttpServlet {
	private static final long serialVersionUID = -1311176251844328163L;
//	private static final String CMD_FLAG = "cmd";
//	private static final String RENAME_CMD = "rename";
//	private static final String TALK_CMD = "talk";
//	private static final String LIST_CMD = "list";
	private static final CometContext context = CometContext.getInstance();
	private static final CometEngine engine = context.getEngine();
	private static final AppStore appStore = AppStore.getInstance();

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String cmd = request.getParameter("cmd");

		if ("rename".equals(cmd)) {
			String id = request.getParameter("id");
			if (id == null)
				return;
			String newName = request.getParameter("newName");
			String oldName = request.getParameter("oldName");
			appStore.put(id, newName);
			RenameDTO dto = new RenameDTO(id, oldName, newName);
			engine.sendToAll("talker", dto);
			return;
		}

		if ("talk".equals(cmd)) {
			String id = request.getParameter("id");
			String name = appStore.get(id);
			String text = request.getParameter("text");
			TalkDTO dto = new TalkDTO(id, name, text);
			engine.sendToAll("talker", dto);
			return;
		}

		if ("list".equals(cmd)) {
			List<UserDTO> userList = new ArrayList<UserDTO>();
			Map<String, String> map = AppStore.getInstance().getMap();
			Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry<String, String> entry = iter.next();
				String id = (String) entry.getKey();
				String name = (String) entry.getValue();
				userList.add(new UserDTO(id, name));
			}
			String json = JSONUtil.convertToJson(userList);
			response.getWriter().print(json);
		}
	}
}