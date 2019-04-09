package com.future.member.api.service;

import java.util.List;

import com.future.member.api.vo.MemberVO;

/**
 * 会员接口
 * @author caojia
 */
public interface MemberService {

    /**
     * 验证用户身份
     * @param userName 用户名
     * @param passwd  密码
     * @return 用户信息
     */
    public MemberVO checkUser(String userName, String passwd);
    
    /**
     * 注册用户
     * @param userName 用户名
     * @param passwd 密码
     */
    public void signUp(String userName, String passwd);
    

    /**
     * 查询所有投资者信息
     * @return 投资者列表
     */
    public List<MemberVO> queryMembers();
    
}
