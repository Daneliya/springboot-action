package com.xxl.springboot.integration.shiro.service.impl;

import com.xxl.springboot.integration.shiro.dao.IActionDAO;
import com.xxl.springboot.integration.shiro.dao.IMemberDAO;
import com.xxl.springboot.integration.shiro.dao.IRoleDAO;
import com.xxl.springboot.integration.shiro.service.IMemberService;
import com.xxl.springboot.integration.shiro.vo.Member;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author xxl
 * @date 2025/2/23 23:36
 */
@Service
public class MemberServiceImpl implements IMemberService {
    @Resource
    private IMemberDAO memberDAO ;
    @Resource
    private IRoleDAO roleDAO ;
    @Resource
    private IActionDAO actionDAO ;
    @Override
    public Member get(String mid) {
        return this.memberDAO.findById(mid);
    }

    @Override
    public Map<String, Set<String>> getRoleAndActionByMember(String mid) {
        Map<String,Set<String>> map = new HashMap<String, Set<String>>() ;
        map.put("allRoles", this.roleDAO.findAllRoleByMember(mid)) ;
        map.put("allActions", this.actionDAO.findAllActionByMember(mid)) ;
        return map;
    }

}
