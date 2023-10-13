import java.util.Scanner;
public class Main {
    private static Employee[] employeeDataArchive = new Employee[10];
    public static void main(String[] args) {

        employeeDataArchive();

        task1();
    }
    public static int departmentNumberGenerator() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(5) + 1;
        }
        int departmentNumberGenerator = arr[0];
        return departmentNumberGenerator;
    }
    public static int salaryValueGenerator() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        int salaryValueGenerator = arr[0];
        return salaryValueGenerator;
    }
    public static Employee [] employeeDataArchive() {
//    public static void Employee [] employeeDataArchive() {

        Employee employee1 = new Employee("Иванов", "Иван", "Иванович", departmentNumberGenerator(), salaryValueGenerator());
        Employee employee2 = new Employee("Петров", "Пётр", "Петрович", departmentNumberGenerator(), salaryValueGenerator());
        Employee employee3 = new Employee("Новая", "Мария", "Олеговна", departmentNumberGenerator(), salaryValueGenerator());
        Employee employee4 = new Employee("Симонов", "Тимофей", "Трифонович", departmentNumberGenerator(), salaryValueGenerator());
        Employee employee5 = new Employee("Виноградова", "Анастасия", "Викторовна", departmentNumberGenerator(), salaryValueGenerator());
        Employee employee6 = new Employee("Неизвестный", "Никита", "Константинович", departmentNumberGenerator(), salaryValueGenerator());
        Employee employee7 = new Employee("Громыко", "Павел", "Ханович", departmentNumberGenerator(), salaryValueGenerator());
        Employee employee8 = new Employee("Ким", "Юрий", "Леонидович", departmentNumberGenerator(), salaryValueGenerator());
        Employee employee9 = new Employee("Великий", "Антон", "Александрович", departmentNumberGenerator(), salaryValueGenerator());
        Employee employee10 = new Employee("Крымская", "Маргарита", "Вячеславовна", departmentNumberGenerator(), salaryValueGenerator());

//        Employee[] employeeDataArchive = new Employee[10];
        employeeDataArchive[0] = employee1;
        employeeDataArchive[1] = employee2;
        employeeDataArchive[2] = employee3;
        employeeDataArchive[3] = employee4;
        employeeDataArchive[4] = employee5;
        employeeDataArchive[5] = employee6;
        employeeDataArchive[6] = employee7;
        employeeDataArchive[7] = employee8;
        employeeDataArchive[8] = employee9;
        employeeDataArchive[9] = employee10;

        return employeeDataArchive;
    }
    public static void archiveToPrint(Employee[] employees) {

        for (int i = 0; i < employees.length; i++) {
            System.out.println("employees = " + employees[i]);
        }
    }
    public static void employeeWithMaxSalary(int selectedDepartment, Employee[] employeeDataArchive) {
        int maxSalary = 0;
        int employeeWithMaxSalary = 0;
        for (int i = 0; i < employeeDataArchive.length; i++) {
            if (employeeDataArchive[i].getDepartment() == selectedDepartment) {
                if (employeeDataArchive[i].getSalary() > maxSalary) {
                    maxSalary = employeeDataArchive[i].getSalary();
                    employeeWithMaxSalary = i;
                }
            }
        }
        System.out.println("maxSalary = " + maxSalary + " " + employeeDataArchive[employeeWithMaxSalary].getSurname() + " " + employeeDataArchive[employeeWithMaxSalary].getName() + " " + employeeDataArchive[employeeWithMaxSalary].getFatherName());
    }
    public static void employeeWithMinSalary(int selectedDepartment, Employee[] employeeDataArchive) {
        int employeeWithMinSalary = 0;
        int minSalary = 0;
        int salaryIntroduce = 0;
        for (int i = 0; i < employeeDataArchive.length; i++) {
            if (employeeDataArchive[i].getDepartment() == selectedDepartment) {
                salaryIntroduce++;
                if (salaryIntroduce == 1) {
                    minSalary = employeeDataArchive[i].getSalary();
                }
            }
            if (employeeDataArchive[i].getDepartment() == selectedDepartment) {
                if (employeeDataArchive[i].getSalary() < minSalary) {
                    minSalary = employeeDataArchive[i].getSalary();
                }
                employeeWithMinSalary = i;
            }
        }
        System.out.println("minSalary = " + minSalary + " " + employeeDataArchive[employeeWithMinSalary].getSurname() + " " + employeeDataArchive[employeeWithMinSalary].getName() + " " + employeeDataArchive[employeeWithMinSalary].getFatherName());
    }
    public static void sumSalary(int selectedDepartment, Employee[] employeeDataArchive) {
        int sumSalary = 0;
        int salaryIntroduce = 0;
        for (int i = 0; i < employeeDataArchive.length; i++) {
            if (employeeDataArchive[i].getDepartment() == selectedDepartment) {
                sumSalary = sumSalary + employeeDataArchive[i].getSalary();
                salaryIntroduce++;
            }
            if (i == employeeDataArchive.length - 1) {
                System.out.println("sumSalary = " + sumSalary);
                if (salaryIntroduce > 0) {
                    System.out.println("sumSalaryAverage = " + sumSalary / salaryIntroduce);
                } else System.out.println("Для расчёта средней зарплаты отдела, нужно наличие хотя бы одного сотрудника в отделе");
            }
        }
    }
    public static void salaryIndexation(int salaryIndexation, int selectedDepartment, Employee[] employeeDataArchive) {
        System.out.println("Индексация зарплаты на " + salaryIndexation + " процентов:");
        int salaryIntroduce = 0;
        for (int i = 0; i < employeeDataArchive.length; i++) {
            if (employeeDataArchive[i].getDepartment() == selectedDepartment) {
                salaryIntroduce++;
                employeeDataArchive[i].setSalary(employeeDataArchive[i].getSalary() + employeeDataArchive[i].getSalary() * salaryIndexation / 100);
                System.out.println(employeeDataArchive[i].getSurname() + " " + employeeDataArchive[i].getName() + " " + employeeDataArchive[i].getFatherName() + ", зарплата: " + employeeDataArchive[i].getSalary() + " персональный номер: " + employeeDataArchive[i].getPersonalNumber());
            } else if (salaryIntroduce == 0 && i == employeeDataArchive.length - 1) System.out.println("Нет сотрудников в отделе, " + selectedDepartment + " чтобы можно было проиндексировать их зарплату");
        }
    }
    public static void salarySamplingParameter(int salarySamplingParameter, Employee[] employeeDataArchive) {
        int signArchiveSize = 0;
        for (int i = 0; i < employeeDataArchive.length; i++) {
            if (employeeDataArchive[i].getSalary() >= salarySamplingParameter) {
                signArchiveSize++;
            }
        }
        if (signArchiveSize == 10) {
            int countyIndexMax = 0;
            Object[] salarySamplingParameterMax = new Object[signArchiveSize];
            for (int i = 0; i < employeeDataArchive.length; i++) {
                if (employeeDataArchive[i].getSalary() >= salarySamplingParameter) {
                    countyIndexMax++;
                    salarySamplingParameterMax[countyIndexMax - 1] = employeeDataArchive[i];
                }
            }
            System.out.println("Информация о сотрудниках с зарплатой, больше или равной " + salarySamplingParameter + ":");
            for (int i = 0; i < salarySamplingParameterMax.length; i++) {
                System.out.println("salarySamplingParameterMax[i] = " + salarySamplingParameterMax[i]);
            }
        } else if (signArchiveSize == 0) {
            int countyIndexMin = 0;
            Object[] salarySamplingParameterMin = new Object[10 - signArchiveSize];
            for (int i = 0; i < employeeDataArchive.length; i++) {
                if (employeeDataArchive[i].getSalary() < salarySamplingParameter) {
                    countyIndexMin++;
                    salarySamplingParameterMin[countyIndexMin - 1] = employeeDataArchive[i];
                }
            }
            System.out.println("Информация о сотрудниках с зарплатой, меньше " + salarySamplingParameter + ":");
            for (int i = 0; i < salarySamplingParameterMin.length; i++) {
                System.out.println("salarySamplingParameterMin[i] = " + salarySamplingParameterMin[i]);
            }
        } else if (signArchiveSize > 0 && signArchiveSize != 10) {
            int countyIndexMax = 0;
            Object[] salarySamplingParameterMax = new Object[signArchiveSize];
            for (int i = 0; i < employeeDataArchive.length; i++) {
                if (employeeDataArchive[i].getSalary() >= salarySamplingParameter) {
                    countyIndexMax++;
                    salarySamplingParameterMax[countyIndexMax - 1] = employeeDataArchive[i];
                }
            }
            System.out.println("Информация о сотрудниках с зарплатой, больше или равной " + salarySamplingParameter + ":");
            for (int i = 0; i < salarySamplingParameterMax.length; i++) {
                System.out.println("salarySamplingParameterMax[i] = " + salarySamplingParameterMax[i]);
            }
            int countyIndexMin = 0;
            Object[] salarySamplingParameterMin = new Object[10 - signArchiveSize];
            for (int i = 0; i < employeeDataArchive.length; i++) {
                if (employeeDataArchive[i].getSalary() < salarySamplingParameter) {
                    countyIndexMin++;
                    salarySamplingParameterMin[countyIndexMin - 1] = employeeDataArchive[i];
                }
            }
            System.out.println("Информация о сотрудниках с зарплатой, меньше " + salarySamplingParameter + ":");
            for (int i = 0; i < salarySamplingParameterMin.length; i++) {
                System.out.println("salarySamplingParameterMin[i] = " + salarySamplingParameterMin[i]);
            }
        }
    }
    public static void task1 () {
        System.out.println("Курсовая работа №1: Повышенная сложность");

        Employee[] employeeDataArchive = employeeDataArchive();
        System.out.println("Данные всех сотрудников, до индексации зарплаты:");
        archiveToPrint(employeeDataArchive);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер отдела по которому нужно сделать выборку (значение от 1 - 5): ");
        int selectedDepartment = scanner.nextInt();

        System.out.println("Расчёт параметров фонда оплаты труда:");
        employeeWithMaxSalary(selectedDepartment, employeeDataArchive);
        employeeWithMinSalary(selectedDepartment, employeeDataArchive);
        sumSalary(selectedDepartment, employeeDataArchive);

        Scanner scannerIndex = new Scanner(System.in);
        System.out.println("Введите значение процента на который нужно индексировать заработную плату: ");
        int salaryIndexation = scannerIndex.nextInt();
        salaryIndexation(salaryIndexation, selectedDepartment, employeeDataArchive);

        Scanner scannerParameter = new Scanner(System.in);
        System.out.println("Введите значение зарплаты относительно размера которой нужно сделать сортировку : ");
        int salarySamplingParameter = scannerParameter.nextInt();
        salarySamplingParameter(salarySamplingParameter, employeeDataArchive);
    }
}

