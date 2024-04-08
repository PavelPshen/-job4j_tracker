package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String massage;

    public Error() {
    }

    public Error(boolean active, int status, String massage) {
        this.active = active;
        this.status = status;
        this.massage = massage;
    }

    public void errorInfo() {
        System.out.println("Активность: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + massage);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error errorCPU = new Error(false, 34, "CPU error");
        Error errorGPU = new Error(true, 11, "GPU error");
        Error errorSSD = new Error(true, 42, "SSD is dead");
        error.errorInfo();
        errorCPU.errorInfo();
        errorGPU.errorInfo();
        errorSSD.errorInfo();
    }
}
