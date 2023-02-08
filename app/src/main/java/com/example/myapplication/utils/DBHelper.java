package com.example.myapplication.utils;

import com.example.myapplication.model.Category;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DBHelper {

    public static FirebaseAuth getFirebaseAuth(){
        return FirebaseAuth.getInstance();
    }

    public static FirebaseUser getLoginUser(){
        return getFirebaseAuth().getCurrentUser();
    }
    public static DatabaseReference getDatabaseReference(){
        return FirebaseDatabase.getInstance().getReference();
    }

    public static DatabaseReference getUserReference(){
        return getDatabaseReference().child("users").child(getUUID());
    }

    private static String getUUID() {
        return getLoginUser() != null ? getLoginUser().getUid() : "";
    }

    public static DatabaseReference getCategoryReference(){
        return getUserReference().child("categories");
    }














    public static void addCategory(Category category){
        getCategoryReference().push().setValue(category);
    }
}
