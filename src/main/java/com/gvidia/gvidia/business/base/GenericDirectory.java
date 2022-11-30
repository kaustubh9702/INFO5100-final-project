/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvidia.gvidia.business.base;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kaustubh
 */
public class GenericDirectory<T extends Identifier>{
    
    public List<T> mList;

    public GenericDirectory() {
        mList = new ArrayList<T>();
    }
    
    
    
    

    public List<T> getList() {
        return mList;
    }

    
    
    public void add(T t) {
        mList.add(t);
    }
    
    public T search(int id) {
        for(T t: mList) {
            if(t.equals(new Integer(id))) {
                return t;
            }
        }
        return null;
    }
    
    public void delete(int id) {
        T t = search(id);
        if(t != null) {
            t = null;
            mList.remove(id);
        } else System.out.println("Search Uncessful");
    }



    
    public int size() {
        return getList().size();
    }

    public T get(int i){
        return i < size() ? getList().get(i) : null;
    }
    
    
}



