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
package cn.itganhuo.app.entity;

import java.io.Serializable;

/**
 * 文章项数据封装类<br>
 * 用于记录其它会员为文章作者所补充的内容，经过原作者审核同意后可展示到前台。
 * 
 * @author 深圳-小兴(504487927)
 * @since 0.0.1-SNAPSHOT
 * @version 2014-08-21
 */
public class ArticleLine implements Serializable {

  private static final long serialVersionUID = 6247891029436503652L;
  private Integer id;
  private Integer userId;
  private Integer articleId;
  private String content;
  private String postDate;
  private Integer praiseNum;
  private Integer trampleNum;
  private Integer isPass = 1;
  private String describe;
  private User user;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getArticleId() {
    return articleId;
  }

  public void setArticleId(Integer articleId) {
    this.articleId = articleId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getPostDate() {
    return postDate;
  }

  public void setPostDate(String postDate) {
    this.postDate = postDate;
  }

  public Integer getPraiseNum() {
    return praiseNum;
  }

  public void setPraiseNum(Integer praiseNum) {
    this.praiseNum = praiseNum;
  }

  public Integer getTrampleNum() {
    return trampleNum;
  }

  public void setTrampleNum(Integer trampleNum) {
    this.trampleNum = trampleNum;
  }

  public Integer getIsPass() {
    return isPass;
  }

  public void setIsPass(Integer isPass) {
    this.isPass = isPass;
  }

  public String getDescribe() {
    return describe;
  }

  public void setDescribe(String describe) {
    this.describe = describe;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ArticleLine other = (ArticleLine) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "ArticleLine [id=" + id + ", userId=" + userId + ", articleId=" + articleId
        + ", content=" + content + ", postDate=" + postDate + ", praiseNum=" + praiseNum
        + ", trampleNum=" + trampleNum + ", isPass=" + isPass + ", describe=" + describe
        + ", user=" + user + "]";
  }

}
