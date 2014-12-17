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

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itganhuo.app.common.pool.ConfigPool;
import cn.itganhuo.app.common.utils.StringUtil;
import cn.itganhuo.app.dao.TemplateDao;
import cn.itganhuo.app.entity.Template;
import cn.itganhuo.app.entity.User;
import cn.itganhuo.app.service.EmailTemplateService;
import cn.itganhuo.app.service.UserService;

@Service
public class EmailTemplateServiceImpl implements EmailTemplateService {

  private TemplateDao templateDao;
  private UserService userService;

  @Autowired
  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  @Autowired
  public void setEmailTemplateMapper(TemplateDao templateDao) {
    this.templateDao = templateDao;
  }

  public int insert(Template template) {
    //template.setId(UUID.randomUUID().toString());
    return templateDao.insert(template);
  }

  public Template loadByName(String name) {
    return templateDao.loadByName(name);
  }

  public List<Template> loadAll() {
    return templateDao.loadAll();
  }

  /*
   * (non-Javadoc)
   * 
   * @see cn.itganhuo.service.EmailTemplateService#loadById(java.lang.String)
   */
  public Template loadById(String id) {
    return templateDao.loadById(id);
  }

  /*
   * (non-Javadoc)
   * 
   * @see cn.itganhuo.service.EmailTemplateService#generateAuthURL(java.lang.String )
   */
  @Transactional
  public String generateAuthURL(String account) {
    /*StringBuffer buffer = new StringBuffer(ConfigPool.getString2("requestGetContextPath"))
        .append("/auth_email/");
    User um = userService.loadByAccount(account);
    buffer.append(um.getId());
    String str = um.getId().concat(account).concat(um.getSalt()) + System.currentTimeMillis();
    String code = StringUtil.getSha512Shiro(str, false);
    buffer.append("/".concat(code));
    User tmp_user2 = new User();
    tmp_user2.setAccount(account);
    tmp_user2.setCode(code);
    tmp_user2.setValidate_date(new Date());
    userService.updateInfoByAccount(tmp_user2);
    return buffer.toString();*/
    return null;
  }

}
