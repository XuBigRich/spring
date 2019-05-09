package top.piao888.ssh.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import top.piao888.ssh.pojo.UserAuth;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserRepository {
    @Resource(name = "sessionFactory1")
    private SessionFactory sessionFactory;
    @SuppressWarnings("unused")
    public Session getSession() {
        System.out.println("1");
        return sessionFactory.getCurrentSession();
    }
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    public List<UserAuth> all() {
        return (List<UserAuth>) this.getSession().createCriteria(UserAuth.class).list();
    }
    public void deleteUserById(Integer id){
        this.getSession().createQuery("delete UserAuth where id = ?").setParameter(0,id).executeUpdate();
    }

    public List<UserAuth>  getPersonById0(Integer id){
        return (List<UserAuth>) this.getSession().createQuery("from UserAuth where did = ?").setParameter(0,id).getResultList();
    }
    public List<UserAuth> getPersonBydname(String dname){
        return (List<UserAuth>)this.getSession().createQuery("from UserAuth where dname = ? ").setParameter(0,dname).getResultList();
    }
    public  List<UserAuth> getPersonById2(Integer id){
        return (List<UserAuth>) this.getSession().createQuery("from UserAuth where did = :xxx").setParameter("xxx",id).getResultList();
    }
    public List<UserAuth> getPersontwoByIdandname(Integer id,String dname){
        return (List<UserAuth>)this.getSession().createQuery("from UserAuth where did = ? and dname = ? ").setParameter(0,id).setParameter(1,dname).getResultList();
    }
    public List<UserAuth> getPersonlikeBydname(String dname){
        return (List<UserAuth>)this.getSession().createQuery("from UserAuth where dname like ? ").setParameter(0,"%"+dname+"%").getResultList();
    }
    public List findByDetached(DetachedCriteria dc){
        List list=dc.getExecutableCriteria(getSession()).list();
        return list;
    }


    //==========================================================
    public List list(String querySql) {
        Query<?> query = getSession().createQuery(querySql);
        return query.getResultList();
    }

    public Object get(Class clazz, String productId) {
        return getSession().get(clazz, productId);
    }


}
