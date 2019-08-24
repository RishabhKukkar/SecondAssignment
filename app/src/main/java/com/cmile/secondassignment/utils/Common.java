package com.cmile.secondassignment.utils;

import com.cmile.secondassignment.adapters.HomeModuleListAdapter;
import com.cmile.secondassignment.adapters.UserListViewAdapter;
import com.cmile.secondassignment.models.HomeModuleList;
import com.cmile.secondassignment.models.UserDetails;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class Common {
    //Array List
    public ArrayList<HomeModuleList> homeModuleLists=new ArrayList<>();
    public List<UserDetails> userDetails=new ArrayList<>();

    //Adapters

    public HomeModuleListAdapter homeModuleListAdapter;
    public UserListViewAdapter userListViewAdapter;


    //Strings
    public String[] HomeModuleList={"Add Information","View Information"};
    public  String postDate;


    // FireBase
    public FirebaseFirestore db = FirebaseFirestore.getInstance();


}
