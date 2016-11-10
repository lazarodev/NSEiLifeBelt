package com.gt.dev.ilifebelt.nseilifebelt.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Community on 26/10/16.
 */
@Table(name = "Result")
public class Results extends Model {
    @Column(name = "name")
    public String name;

    @Column(name = "email")
    public String email;

    @Column(name = "nse")
    public String nse;
}
