package com.wanxp.blog.model.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "role")
@DynamicInsert(true)
@DynamicUpdate(true)
@Data
public class Role{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, length = 10)
    private Integer id;
    @Column(name = "tenant_id", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
    private Integer tenantId;
    @Column(name = "addtime", unique = false, nullable = false, insertable = true, updatable = true, length = 19)
    private Date addtime;
    @Column(name = "updatetime", unique = false, nullable = false, insertable = true, updatable = true, length = 19)
    private Date updatetime;
    @Column(name = "isdeleted", unique = false, nullable = false, insertable = true, updatable = true, length = 0)
    private Boolean isdeleted;
    @Column(name = "name", unique = true, nullable = false, insertable = true, updatable = true, length = 64)
    private String name;
    @Column(name = "authority", unique = true, nullable = false, insertable = true, updatable = true, length = 64)
    private String authority;

    @OneToMany
    @JoinColumn(name = "parent_id")
    private List<Role> children;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Role parent;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", inverseJoinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")}, joinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<User> userList;
}
