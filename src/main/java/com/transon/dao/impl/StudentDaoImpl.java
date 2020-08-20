package com.transon.dao.impl;

import com.transon.dao.IStudentDao;
import com.transon.entity.Student;
import com.transon.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class StudentDaoImpl extends GenericDaoImpl<Student> implements IStudentDao{

    @Override
    public List<Student> searchByName(String q) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Student> results = null;
        try {
            Criteria criteria = session.createCriteria(Student.class);
            results = criteria.add(Restrictions.like("fullName", q, MatchMode.ANYWHERE)).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return results;
    }
}
