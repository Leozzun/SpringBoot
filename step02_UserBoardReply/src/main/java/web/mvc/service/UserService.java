package web.mvc.service;

import org.springframework.stereotype.Service;
import web.mvc.domain.User;

@Service
public interface UserService {
	/**
	 * �로그인하기
	 * */
   User loginCheck(User user);
}
