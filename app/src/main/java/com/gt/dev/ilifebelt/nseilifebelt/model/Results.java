package com.gt.dev.ilifebelt.nseilifebelt.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Community on 26/10/16.
 */
@Table(name = "Results")
public class Results extends Model {

    //The table consist only one field name
    @Column(name = "name")
    public String name;

}
