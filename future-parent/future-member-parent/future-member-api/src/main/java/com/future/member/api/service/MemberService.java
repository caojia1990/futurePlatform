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
     * @param userName
     * @param passwd
     * @return
     */
    public MemberVO checkUser(String userName, String passwd);
    
    /**
     * 注册用户
     * @param userName
     * @param passwd
     */
    public void signUp(String userName, String passwd);
    

    /**
     * 查询所有投资者信息
     * @return
     */
    public List<MemberVO> queryMembers();
    
}
