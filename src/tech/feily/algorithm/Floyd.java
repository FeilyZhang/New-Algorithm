package tech.feily.algorithm;

/**
 * @author Administrator 
 * @date : 2019��1��31������3:50:55
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class Floyd {

    private Object[] mapping;
    private Object[][] matrix;
    
    public Floyd(Object[] mapping) {
        int length = mapping.length;
        this.mapping = new Object[length];
        matrix = new Object[length][length];
        for (int i = 0; i < length; i++) {
            this.mapping[i] = mapping[i];
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = 0;
            }
        }
    }
    
    /*
     * emmm���÷���ͨ��ȷ��start��end�ھ���matrix�е����꣬Ȼ������ֵΪ1���Ӷ�ȷ��start��end��ı߹�ϵ
     * @param start �ò���Ϊ��ʼ����
     * @param end �ò���Ϊ��ֹ����
     */
    public void addEdge(Object start, Object end, int value) {
        int row = -1;
        int col = -1;
        // Ѱ������
        for (int i = 0; i < mapping.length; i++) {
            // ��ʼ����Ϊrow = -1, col = -1
            // �����ʼ���귢���仯����ô�Ϳ�����Ϊ�Ѿ�Ѱ�ҵ�����Ӧ����
            if (row != -1 && col != -1) {
                break;
            }
            // ��Ҫע����ǣ�������㼯����������Ϊint���Ҷ�������(��0�� 1�� 2�� 3)����ô��������ǿ���ʡ�Ե�
            // ��Ϊ���㱾���������
            // ����Ѱ������ָ����һά���㼯���������Ͳ�Ϊint�Ҳ���������ôֻ��ͨ���������㼯�ķ�ʽ��ȡ�������ڶ��㼯�е�����
            // ��ʵ����Ѱ�Ҷ�����mapping�е�������Ҳ��������matrix�е�����
            if (start == mapping[i]) {
                row = i;
            }
            
            if (end == mapping[i]) {
                col = i;
            }
        }
        
        // �жϸ������Ƿ�Ϸ�(�����)
        if (row == -1 || col == -1 || row > mapping.length - 1 || col > mapping.length - 1) {
            throw new IndexOutOfBoundsException("The vertex of the edge does not exist or the coordinates are illegal.");
        }
        matrix[row][col] = value;   //������������Ϊ1����ô����˵������start(����Ϊrow)�붥��end(����Ϊcol)���ڱ�
    }
    
    public void printMatrix() {
        // ��һ����ʵ�е���࣬��Ϊ���ǵľ���matrix������ΪObject
        // ������ǲ���������ֵ�Ļ�����ô����null
        // ���ÿ������ǽ�null�滻Ϊ0,�������64��if (obj == null) obj = 0;
        for (Object[] object : matrix) {
            for (Object obj : object) {
                //if (obj == null) obj = 0;
                System.out.print(obj + " ");
            }
            System.out.println();
        }
    }
    
    public void floyd() {
        System.out.println();
        int n = mapping.length;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k] != null && matrix[k][j] != null && (int)matrix[i][j] > (int)matrix[i][k] + (int)matrix[k][j]) {
                        matrix[i][j] = ((int)matrix[i][k] + (int)matrix[k][j]);
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Integer[] vertexes = {1, 2, 3, 4, 5, 6};
        Floyd graph = new Floyd(vertexes);
        graph.addEdge(1, 2, 16); graph.addEdge(2, 1, 16);
        graph.addEdge(1, 3, 1); graph.addEdge(3, 1, 1);
        graph.addEdge(1, 5, 12); graph.addEdge(5, 1, 12);
        graph.addEdge(1, 6, 15); graph.addEdge(6, 1, 15);
        graph.addEdge(2, 4, 2); graph.addEdge(4, 2, 2);
        graph.addEdge(2, 6, 8); graph.addEdge(6, 2, 8);
        graph.addEdge(3, 5, 5); graph.addEdge(5, 3, 5);
        graph.addEdge(4, 6, 3); graph.addEdge(6, 4, 3);
        graph.addEdge(5, 6, 8); graph.addEdge(6, 5, 8);
        graph.addEdge(4, 5, 9); graph.addEdge(5, 4, 9);
        graph.printMatrix();
        graph.floyd();
    }
}

