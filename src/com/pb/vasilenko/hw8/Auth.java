package com.pb.vasilenko.hw8;

public class Auth {

    private String login = "";
    private String password = "";

    public void signUp(String login, String password, String confirmPassword) throws WrongLoginException,
            WrongPasswordException  {

        //Проверки логина

        //Проверка длинны логина
        if(login.length() < 5 || login.length() > 20){
            throw new WrongLoginException("Ошибка. Длинна логина должна быть от 5 до 20 символов.");
        }

        //Проверка символов логина
        if((!provStr(login,false))){
            throw new WrongLoginException("Ошибка. Логин должен содержать только латинские буквы и цифры.");
        }


        //Проверки пароля

        //Совпадение паролей
        if(!(password.equals(confirmPassword))){
            throw new WrongPasswordException("Ошибка. Пароли не совпадают.");
        }

        //Проверка длинны пароля
        if(password.length() <= 5){
            throw new WrongPasswordException("Ошибка. Длинна пароля должна быть более 5 символов.");
        }

        //Проверка символов пароля
        if(!provStr(password,true)){
            throw new WrongPasswordException("Ошибка. " +
                    "Пароль должен содержать только латинские буквы и цифры, а так же знак подчеркивания.");
        }

        setLogin(login);
        setPassword(password);

        System.out.println("Регистрация нового пользователя заверешена успешно!");

    }

    public void signIn(String login, String password) throws WrongLoginException{

        if(this.login.equals(login) && this.password.equals(password)) {
            System.out.println("Вход на сайт выполнен успешно!");
        }else {
            throw new WrongLoginException("Ошибка. Логин или пароль не совпадают.");
        }

    }


    //private String getLogin() {
    //    return login;
    //}

    public void setLogin(String login) {
        this.login = login;
    }

    //private String getPassword() {
    //    return password;
    //}

    public void setPassword(String password) {
        this.password = password;
    }


    private boolean provStr(String Str, boolean parol){

        boolean metkBukvGlob = false;
        boolean metkCifrGlob = false;
        boolean metkSimvolGlob = false;

        String[] masStr  = Str.split("");

        //Перебор всех символов
        for(int i = 0; i < masStr.length; i++){

            boolean metkBukv = false;
            boolean metkCifr = false;
            boolean metkSimvol = false;

            //Буквы
            if(masStr[i].matches("^[a-zA-Z]+")) {
                metkBukv = true;
                metkBukvGlob = true;
            }

            //Цифры
            if (masStr[i].matches("^[0-9]+")){
                metkCifr = true;
                metkCifrGlob = true;
            }

            //Символ
            if (masStr[i].equals("_")){
                metkSimvol = true;
                metkSimvolGlob = true;
            }


            if(!metkBukv && !metkCifr){

                if(parol && metkSimvol){
                   continue;
                }

                return false;
            }

        }

        if(!parol && metkBukvGlob && metkCifrGlob){
            return true;
        }

        if(parol && metkBukvGlob && metkCifrGlob && metkSimvolGlob){
            return true;
        }

        return false;
    }
}
