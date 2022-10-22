package com.ywc.service;

import com.ywc.domain.Role;
import com.ywc.domain.RoleMenuVo;

import java.util.List;

public interface RoleService {

    /*查询所有角色*/
    public List<Role> findAllRole(Role role);

/*根据角色id查询角色关联的菜单信息Id【1,2,3，4,5】*/
    public List<Integer> findMenuByRoleId(Integer roleId);



    /*为角色分配菜单*/

    public void roleContextMenu(RoleMenuVo roleMenuVo);

    /*删除角色 */


    public void deleteRole(Integer rid);
}
