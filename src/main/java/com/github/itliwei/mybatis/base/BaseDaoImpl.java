package com.github.itliwei.mybatis.base;

import com.github.itliwei.MyBaseMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class BaseDaoImpl<T extends IdEntity> implements BaseDao<T> {

    @Autowired
    private MyBaseMapper myBaseMapper;
    
    @Override
    @Transactional
    public int save(T t) {
        return myBaseMapper.insertSelective(t);
    }

    @Override
    @Transactional
    public int saveAll(List<T> list) {
        return myBaseMapper.insertList(list);

    }

    @Override
    @Transactional
    public int delete(T t) {
        return myBaseMapper.delete(t);
    }

    @Override
    @Transactional
    public int deleteById(Long id) {
        return myBaseMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int update(T t) {
        return myBaseMapper.updateByPrimaryKey(t);
    }

    @Override
    public T getById(Long id) {
        return (T) myBaseMapper.selectByPrimaryKey(id);

    }

    @Override
    public List<T> getAll() {
        return myBaseMapper.selectAll();
    }

    @Override
    public List<T> searchByExample(Example example) {
        return myBaseMapper.selectByExample(example);
    }

    @Override
    public PageInfo<T> findByPage(int pageNum,int pageSize,Example example) {
        PageHelper.startPage(pageNum,pageSize);
        List<T> list = myBaseMapper.selectByExample(example);
        return new PageInfo<T>(list);
    }


}
