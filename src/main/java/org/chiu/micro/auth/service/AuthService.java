package org.chiu.micro.auth.service;


import org.chiu.micro.auth.vo.MenusAndButtonsVo;

import java.util.List;

public interface AuthService {

    MenusAndButtonsVo getCurrentUserNav(List<String> role);

}
