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
package cn.itganhuo.app.service;

import java.util.List;
import java.util.Map;

import cn.itganhuo.app.entity.Article;
import cn.itganhuo.app.entity.ArticleLabel;

/**
 * 对文章做业务操作的接口
 * 
 * @author 深圳-小兴(504487927) 2014-8-21
 * @since itganhuo1.0
 */
public interface ArticleService {

  /**
   * 查询文章列表
   * <ol>
   * <li>（带分页）</li>
   * </ol>
   * 
   * @author 深圳-小兴(504487927) 2014-8-21
   * @since itganhuo1.0
   * @param article
   * @return
   */
  public List<Article> findArticleByCondition(Map<String, Object> map);

  /**
   * <h3>根据主键查询文章详情及其对应的作者</h3>
   * 
   * @author 深圳-小兴(504487927) 2014-8-22
   * @param id
   * @return
   */
  public Article getArticleById(String id);

  /**
   * 查询文章详细信息，包括作者、补充、评论、评论人信息、回复、回复人信息
   * <ol>
   * <li>联表查询数据比较多，这个查询主要是给文章详情页用，如果你用不到这么多信息，建议还是另外写一个方法为好。</li>
   * </ol>
   * 
   * @author 深圳-小兴(504487927)
   * @version 2014-11-20
   * @param id
   *          文章主键
   * @return
   */
  public Article getArticleDetailById(String id);

  /**
   * 统计文章总数
   * 
   * @author 深圳-小兴(504487927) 2014-8-27
   * @since itganhuo1.0
   * @param map
   * @return
   */
  public int countArticleRows();

  /**
   * 会员添加一遍文章
   * <ol>
   * <li>由会员登录后在用户中心提交表单</li>
   * </ol>
   * 
   * @author 深圳-小兴(504487927) 2014-9-15
   * @since itganhuo1.0
   * @param article_model
   * @return
   */
  public String addArticle(Article article_model);

  /**
   * 在用户中心查询它最近发布的5篇文章
   * 
   * @author 深圳-小兴(504487927) 2014-9-17
   * @since itganhuo1.0
   * @param id
   * @return
   */
  public List<Article> getArticleByUserId(String user_id);

  /**
   * 增加浏览次数
   * 
   * @author Java私塾在线学习社区（329232140）深圳-夕落946594780 2014年10月7日 下午12:08:08
   * @author 深圳-夕落
   * @since itganhuo1.0
   * @param id
   *          文章id
   * @return
   */
  public boolean addVisitor_volumeById(String id);

  /**
   * 保存文章和标签之间的关系 保存文章和标签之间的关系 文章点赞
   * 
   * @author Java私塾在线学习社区（329232140）深圳-夕落946594780 2014年10月7日 下午4:02:00
   * @author 只要修改了这个类就到类注释上写上你的名字
   * @since itganhuo1.0
   * @param id
   *          文章id
   * @return
   */
  public boolean insertArticleSubject(ArticleLabel articleLabel);

  /**
   * 文章点踩
   * 
   * @author Java私塾在线学习社区（329232140）深圳-夕落946594780 2014年11月19日 下午3:41:35
   * @author 只要修改了这个类就到类注释上写上你的名字
   * @since itganhuo1.0
   * @return
   */
  public boolean addUseful(String article_id);

  /**
   * 
   * <p>
   * 文章点踩
   * </p>
   * <ol>
   * <li></li>
   * </ol>
   * 
   * @author Java私塾在线学习社区（329232140）深圳-夕落946594780 2014年11月19日 下午3:43:03
   * @author 只要修改了这个类就到类注释上写上你的名字
   * @since itganhuo1.0
   * @param article_id
   * @return
   */
  public boolean addUseless(String article_id);

  /**
   * 根据文章id得到相同标签下的文章（不包含自己）
   */
  public List<Article> getArticleBySubject(String id);

  /**
   * 
   * <p>
   * 增加文章表的评论次数
   * </p>
   * 
   * @author Java私塾在线学习社区（329232140）深圳-夕落946594780 2014年11月22日 下午3:55:50
   * @since itganhuo1.0
   * @param article_id
   * @return
   */
  public boolean addAnswer_number(String article_id);
}
