package com.shoes.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the users database table.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String username;
    private String name;

    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    private int status;

    private int verifyStatus;

    private UUID verifyCode;
    //bi-directional many-to-one association to Address
    @OneToMany(mappedBy = "user")
    private List<Address> addresses;

    //bi-directional many-to-one association to Order
    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    //bi-directional many-to-one association to ReturnItem
    @OneToMany(mappedBy = "user")
    private List<ReturnItem> returnItems;

    //bi-directional many-to-one association to Role
    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;
}