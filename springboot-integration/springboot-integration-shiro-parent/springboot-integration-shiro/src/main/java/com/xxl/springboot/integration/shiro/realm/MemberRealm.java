package com.xxl.springboot.integration.shiro.realm;

import com.xxl.springboot.integration.shiro.service.IMemberService;
import com.xxl.springboot.integration.shiro.vo.Member;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;

/**
 * @author xxl
 * @date 2025/2/23 23:31
 */
public class MemberRealm extends AuthorizingRealm {

    @Resource
    private IMemberService memberService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 此方法主要是实现用户的认证处理操作
        System.err.println("=========== 1、进行用户认证处理操作（doGetAuthenticationInfo()） ===========");
        String mid = (String) token.getPrincipal(); // 获得用户名的信息
        Member member = this.memberService.get(mid);    // 根据用户名查询出用户的完整信息

        if (member == null) {    // 用户信息不存在，不存在的信息应该抛出未知的账户异常
            throw new UnknownAccountException("账户“" + mid + "”不存在。");
        }    // 需要对密码进行加密处理，因为从数据库之中取出的密码是加密后的文字信息
        if (member.getLocked().equals(1)) {    // 用户被锁定了
            throw new LockedAccountException(mid + "账户信息已经被锁定，无法登录！");
        }    // 要传递加密后的密码数据信息
        SecurityUtils.getSubject().getSession().setAttribute("name", member.getName());
        return new SimpleAuthenticationInfo(token.getPrincipal(), member.getPassword(), "memberRealm");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 此方法主要用于用户的授权处理操作，授权一定要在认证之后进行
        System.err.println("=========== 2、进行用户授权处理操作（doGetAuthorizationInfo()） ===========");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();    // 返回授权的信息
        String mid = (String) principals.getPrimaryPrincipal();    // 获得用户名

        Map<String, Set<String>> map = this.memberService.getRoleAndActionByMember(mid);
        info.setRoles(map.get("allRoles")); // 将所有的角色信息保存在授权信息中
        info.setStringPermissions(map.get("allActions")); // 保存所有的权限

        return info;
    }

}