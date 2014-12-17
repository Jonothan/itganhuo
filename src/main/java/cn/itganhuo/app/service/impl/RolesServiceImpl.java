/*
 * Solemnly declare(2014-11-11):
 * 1 This project is a collective creation of its copyrighted Java private school online learning community (QQ group number 329 232 140) of all, is prohibited without the author's permission for commercial profit without permission;
 * 2 See the list of IT ganhuo sharing network http://www.itganhuo.cn/teams;
 * 3, the author does not guarantee the quality of the project and its stability, reliability, and security does not assume any responsibility if you get the source code for this project in some way, all the consequences of the subsequent occurrence of ego nothing to do with this group and author;
 * 4 mx.tian@qq.com have any questions, please contact us.
 *
 * 郑重声明(2014-11-11)：
 * 1、本项目属集体创作其版权归Java私塾在线学习社区（QQ群号329232140）作者所有，禁止未经作者授权擅自用于商业盈利；
 * 2、作者名单详见IT干货技术分享网http://www.itganhuo.cn/teams；
 * 3、作者不保证项目质量并对其稳定性、可靠性和安全性不承担任何责任，如果你通过某些途径获取本项目源代码，其后发生的一切后果自负与本群及作者无关；
 * 4、有任何问题请与我们联系mx.tian@qq.com。
 */
package cn.itganhuo.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itganhuo.app.dao.RolesDao;
import cn.itganhuo.app.entity.Roles;
import cn.itganhuo.app.service.RolesService;

@Service
public class RolesServiceImpl implements RolesService {

  private RolesDao rolesDao;

  @Autowired
  public void setRolesMapper(RolesDao rolesDao) {
    this.rolesDao = rolesDao;
  }

  public boolean addRoless(Roles roles) {
    roles.setId(UUID.randomUUID().toString());
    return rolesDao.insert(roles) == 1;
  }

  public boolean updateInfoRoles(Roles roles) {
    return rolesDao.updateInfo(roles) == 1;
  }

  public boolean delRoles(String id) {
    return rolesDao.delete(id) == 1;
  }

  public Roles getRolesModelById(String id) {
    return rolesDao.loadById(id);
  }

  public Map<String, List<Object>> getRolesList(Map<Object, Object> condition) {
    List<Object> list = rolesDao.getRolesList(condition);
    List<Object> total = new ArrayList<Object>();
    if (list != null && list.size() > 0) {
      total.add(rolesDao.countRolesList(condition));
    }
    Map<String, List<Object>> map = new HashMap<String, List<Object>>();
    map.put("total", total);
    map.put("rows", list);
    return map;
  }

}
