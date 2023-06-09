package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {

        return emailId;
    }

    public String getPassword() {

        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
         boolean checkCondition=checkNewPasswordCondition(newPassword);
         if(this.password.equals(oldPassword) && checkCondition){
             this.password=newPassword;
         }

    }


    private boolean checkNewPasswordCondition( String newPassword){
        boolean checkUpperCase=false;
        boolean checkLowerCase=false;
        boolean checkDigit=false;
        boolean checkSpecialCharacter=false;
        boolean checkLength=false;
        for(int i=0;i<newPassword.length();i++){
            char ch=newPassword.charAt(i);
            if(Character.isUpperCase(ch)){

                checkUpperCase=true;
            } else if(Character.isLowerCase(ch)){
                checkLowerCase=true;
            } else if (Character.isDigit(ch)){
                checkDigit=true;

            } else if(!Character.isDigit(ch) && !Character.isLetter(ch)){
                checkSpecialCharacter=true;
            }
        }
        if(newPassword.length()>=8)
            checkLength=true;

        if(checkUpperCase && checkLowerCase && checkDigit && checkSpecialCharacter && checkLength)
            return true;

        return false;
    }

}
