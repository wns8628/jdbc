package com.douzone.jdbc.bookshop.vo;

public class AuthorVo {	
   private long no;
   private String name;
   private String bio;

   public long getNo() {
      return no;
   }

   public void setNo(long no) {
      this.no = no;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getBio() {
      return bio;
   }

   public void setBio(String bio) {
      this.bio = bio;
   }

   @Override
   public String toString() {
      return "AuthorVO [no=" + no + ", name=" + name + ", bio=" + bio + "]";
   }

}