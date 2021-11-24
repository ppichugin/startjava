public class Variable {
    
    public static void main(String[] args) {
    // Объявляем переменные примитивных типов данных
    byte quantityDisks = 1;
    long ssdSizeBites = 510_770_802_688L;
    int ssdSizeGb = (int) (ssdSizeBites / 1000000000);
    int quantityFiles = 437_056;
    int quantityFolders = 154064;
    short ramGb = 16;
    double ramGbMaxUse = 15.9;
    float cpuBaseFrequencyHz = 1.8F;
    double cpuMaxFrequencyHz = 4.0D;
    byte cpuCores = 4;
    char symbol = '!';
    char symbolCr = '\n';
    boolean isMine = true;

        //Выводим переменные на экран
        System.out.println("Параметры персонального компьютера:" + symbolCr);
        System.out.println("Тип операционной системы: " + '\t' + "Windows 10 Pro. Версия 21H1");
        System.out.println("Количество дисков: " + '\t' + '\t' + quantityDisks);
        System.out.println("Объем диска SSD: " + '\t' + '\t' + ssdSizeBites + " байт. (" + ssdSizeGb + " Гб)");
        System.out.println("Количество файлов: " + '\t' + '\t' + quantityFiles);
        System.out.println("Количество папок: " + '\t' + '\t' + quantityFolders + symbolCr);
        System.out.println("Объем оперативной памяти: " + '\t' + ramGb + " Гб" + " (доступно: " + ramGbMaxUse + " Гб)");
        System.out.println("Тип процессора: " + '\t' + '\t' + "Intel Core i7-8550U");
        System.out.println("Частота: " + '\t' + '\t' + '\t' + cpuBaseFrequencyHz + " Гц. (Макс. частота: " + cpuMaxFrequencyHz + " Гц.)");
        System.out.println("Число ядер: " + '\t' + '\t' + '\t' + cpuCores + symbolCr);
            if (isMine) {
                System.out.println("Это мой ПК" + symbol);
            } else {
                System.out.println("Это чужой ПК" + symbol);
            }
    }
}