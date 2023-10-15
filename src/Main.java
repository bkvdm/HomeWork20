import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Employee[] employeeDataArchive = new Employee[10];

    public static void main(String[] args) {
        employeeDataArchive();
        task1();
    }

    public static int departmentNumberGenerator() {
        java.util.Random random = new java.util.Random();
        int minimumScore = 1;
        int departmentNumberGenerator = random.nextInt(5) + minimumScore;
        return departmentNumberGenerator;
    }

    public static int salaryValueGenerator() {
        java.util.Random random = new java.util.Random();
        int minimumScore = 100_000;
        int salaryValueGenerator = random.nextInt(300_000) + minimumScore;
        return salaryValueGenerator;
    }

    public static List<Employee> employeeDataArchive() {
        List<Employee> employeeDataArchive = new ArrayList<>(Arrays.asList(
                new Employee("Иванов", "Иван", "Иванович", departmentNumberGenerator(), salaryValueGenerator()),
                new Employee("Петров", "Пётр", "Петрович", departmentNumberGenerator(), salaryValueGenerator()),
                new Employee("Новая", "Мария", "Олеговна", departmentNumberGenerator(), salaryValueGenerator()),
                new Employee("Симонов", "Тимофей", "Трифонович", departmentNumberGenerator(), salaryValueGenerator()),
                new Employee("Виноградова", "Анастасия", "Викторовна", departmentNumberGenerator(), salaryValueGenerator()),
                new Employee("Неизвестный", "Никита", "Константинович", departmentNumberGenerator(), salaryValueGenerator()),
                new Employee("Громыко", "Павел", "Ханович", departmentNumberGenerator(), salaryValueGenerator()),
                new Employee("Ким", "Юрий", "Леонидович", departmentNumberGenerator(), salaryValueGenerator()),
                new Employee("Великий", "Антон", "Александрович", departmentNumberGenerator(), salaryValueGenerator()),
                new Employee("Крымская", "Маргарита", "Вячеславовна", departmentNumberGenerator(), salaryValueGenerator())));

        return employeeDataArchive;
    }

    public static void archiveToPrint(List<Employee> employees) {

        for (int i = 0; i < employees.size(); i++) {
            System.out.println("employees = " + employees.get(i));
        }
    }

    public static void employeeWithMaxSalary(int selectedDepartment, List<Employee> employeeDataArchive) {
        int maxSalary = 0;
        int employeeWithMaxSalary = 0;
        for (int i = 0; i < employeeDataArchive.size(); i++) {
            if (employeeDataArchive.get(i).getDepartment() == selectedDepartment) {
                if (employeeDataArchive.get(i).getSalary() > maxSalary) {
                    maxSalary = employeeDataArchive.get(i).getSalary();
                    employeeWithMaxSalary = i;
                }
            }
        }
        System.out.println("maxSalary = " + maxSalary + " " + employeeDataArchive.get(employeeWithMaxSalary).getSurname() + " " + employeeDataArchive.get(employeeWithMaxSalary).getName() + " " + employeeDataArchive.get(employeeWithMaxSalary).getFatherName());
    }

    public static void employeeWithMinSalary(int selectedDepartment, List<Employee> employeeDataArchive) {
        int employeeWithMinSalary = 0;
        int minSalary = 0;
        int salaryIntroduce = 0;
        for (int i = 0; i < employeeDataArchive.size(); i++) {
            if (employeeDataArchive.get(i).getDepartment() == selectedDepartment) {
                salaryIntroduce++;
                if (salaryIntroduce == 1) {
                    minSalary = employeeDataArchive.get(i).getSalary();
                }
            }
            if (employeeDataArchive.get(i).getDepartment() == selectedDepartment) {
                if (employeeDataArchive.get(i).getSalary() < minSalary) {
                    minSalary = employeeDataArchive.get(i).getSalary();
                }
                employeeWithMinSalary = i;
            }
        }
        System.out.println("minSalary = " + minSalary + " " + employeeDataArchive.get(employeeWithMinSalary).getSurname() + " " + employeeDataArchive.get(employeeWithMinSalary).getName() + " " + employeeDataArchive.get(employeeWithMinSalary).getFatherName());
    }

    public static void sumSalary(int selectedDepartment, List<Employee> employeeDataArchive) {
        int sumSalary = 0;
        int salaryIntroduce = 0;
        for (int i = 0; i < employeeDataArchive.size(); i++) {
            if (employeeDataArchive.get(i).getDepartment() == selectedDepartment) {
                sumSalary = sumSalary + employeeDataArchive.get(i).getSalary();
                salaryIntroduce++;
            }
            if (i == employeeDataArchive.size() - 1) {
                System.out.println("sumSalary = " + sumSalary);
                if (salaryIntroduce > 0) {
                    System.out.println("sumSalaryAverage = " + sumSalary / salaryIntroduce);
                } else
                    System.out.println("Для расчёта средней зарплаты отдела, нужно наличие хотя бы одного сотрудника в отделе");
            }
        }
    }

    public static void salaryIndexation(int salaryIndexation, int selectedDepartment, List<Employee> employeeDataArchive) {
        System.out.println("Индексация зарплаты на " + salaryIndexation + " процентов:");
        int salaryIntroduce = 0;
        for (int i = 0; i < employeeDataArchive.size(); i++) {
            if (employeeDataArchive.get(i).getDepartment() == selectedDepartment) {
                salaryIntroduce++;
                employeeDataArchive.get(i).setSalary(employeeDataArchive.get(i).getSalary() + employeeDataArchive.get(i).getSalary() * salaryIndexation / 100);
                System.out.println(employeeDataArchive.get(i).getSurname() + " " + employeeDataArchive.get(i).getName() + " " + employeeDataArchive.get(i).getFatherName() + ", зарплата: " + employeeDataArchive.get(i).getSalary() + " персональный номер: " + employeeDataArchive.get(i).getPersonalNumber());
            } else if (salaryIntroduce == 0 && i == employeeDataArchive.size() - 1)
                System.out.println("Нет сотрудников в отделе, " + selectedDepartment + " чтобы можно было проиндексировать их зарплату");
        }
    }

    public static void salarySamplingParameter(int salarySamplingParameter, List<Employee> employeeDataArchive) {
        int signArchiveSize = 0;
        for (int i = 0; i < employeeDataArchive.size(); i++) {
            if (employeeDataArchive.get(i).getSalary() >= salarySamplingParameter) {
                signArchiveSize++;
            }
        }
        if (signArchiveSize == employeeDataArchive.size()) {
            int countyIndexMax = 0;
//            Object[] salarySamplingParameterMax = new Object[signArchiveSize];
            List<Object> salarySamplingParameterMax = new ArrayList<>(Arrays.asList());
            for (int i = 0; i < employeeDataArchive.size(); i++) {
                if (employeeDataArchive.get(i).getSalary() >= salarySamplingParameter) {
                    countyIndexMax++;
//                    salarySamplingParameterMax.set((i - 1), employeeDataArchive.get(i));
                    salarySamplingParameterMax.add(employeeDataArchive.get(i));
//                            [countyIndexMax - 1] = employeeDataArchive.get(i);
                }
            }
            System.out.println("Информация о сотрудниках с зарплатой, больше или равной " + salarySamplingParameter + ":");
            for (int i = 0; i < salarySamplingParameterMax.size(); i++) {
                System.out.println("salarySamplingParameterMax[i] = " + salarySamplingParameterMax.get(i));
            }
        } else if (signArchiveSize == 0) {
            int countyIndexMin = 0;
//            Object[] salarySamplingParameterMin = new Object[10 - signArchiveSize];
            List<Object> salarySamplingParameterMin = new ArrayList<>(Arrays.asList());
            for (int i = 0; i < employeeDataArchive.size(); i++) {
                if (employeeDataArchive.get(i).getSalary() < salarySamplingParameter) {
                    countyIndexMin++;
//                    salarySamplingParameterMin.set((countyIndexMin - 1), employeeDataArchive.get(i));
                    salarySamplingParameterMin.add(employeeDataArchive.get(i));
                }
            }
            System.out.println("Информация о сотрудниках с зарплатой, меньше " + salarySamplingParameter + ":");
            for (int i = 0; i < salarySamplingParameterMin.size(); i++) {
                System.out.println("salarySamplingParameterMin[i] = " + salarySamplingParameterMin.get(i));
            }
        } else if (signArchiveSize > 0 && signArchiveSize != 10) {
            int countyIndexMax = 0;
//            Object[] salarySamplingParameterMax = new Object[signArchiveSize];
            List<Object> salarySamplingParameterMax = new ArrayList<>(Arrays.asList());
            for (int i = 0; i < employeeDataArchive.size(); i++) {
                if (employeeDataArchive.get(i).getSalary() >= salarySamplingParameter) {
                    countyIndexMax++;
//                    salarySamplingParameterMax.set((countyIndexMax - 1), employeeDataArchive.get(i));
                    salarySamplingParameterMax.add(employeeDataArchive.get(i));
                }
            }
            System.out.println("Информация о сотрудниках с зарплатой, больше или равной " + salarySamplingParameter + ":");
            for (int i = 0; i < salarySamplingParameterMax.size(); i++) {
                System.out.println("salarySamplingParameterMax[i] = " + salarySamplingParameterMax.get(i));
            }
            int countyIndexMin = 0;
//            Object[] salarySamplingParameterMin = new Object[10 - signArchiveSize];
            List<Object> salarySamplingParameterMin = new ArrayList<>(Arrays.asList());
            for (int i = 0; i < employeeDataArchive.size(); i++) {
                if (employeeDataArchive.get(i).getSalary() < salarySamplingParameter) {
                    countyIndexMin++;
//                    salarySamplingParameterMin.set((countyIndexMin - 1), employeeDataArchive.get(i));
                    salarySamplingParameterMin.add(employeeDataArchive.get(i));
                }
            }
            System.out.println("Информация о сотрудниках с зарплатой, меньше " + salarySamplingParameter + ":");
            for (int i = 0; i < salarySamplingParameterMin.size(); i++) {
                System.out.println("salarySamplingParameterMin[i] = " + salarySamplingParameterMin.get(i));
            }
        }
    }

    public static void task1() {
        System.out.println("Курсовая работа №1: Повышенная сложность");

        List<Employee> employeeDataArchive = employeeDataArchive();
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