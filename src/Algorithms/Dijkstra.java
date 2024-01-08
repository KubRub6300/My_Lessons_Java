package Algorithms;

import com.sun.source.tree.WhileLoopTree;

import java.util.*;


/**
 * @author Danil Kubarev
 * @version 1.0<br>
 * <div style="font-size:40px">Алгоритм Дейкстры</div><br>
 * Позволяет найти оптимальный маршрут между двумя вершинами графа учитывая веса рёбер.<br>
 * В данном классе реализован поиск пути для графа изображённого ниже.<br>
 * <div style="width: 100%; float: left"> <img src="doc-files/dijkstraGraph.png" alt=""> </div>
 * @see BreadthFirstSearch
 * */
public class Dijkstra {

    /**
     * Стартовый метод.
     * */
    public static void main(String[] args) {

        HashMap<String, HashMap<String,Integer>> graph = new HashMap<>();
        graph.put("start",new HashMap<String, Integer>());
        graph.get("start").put("a",6);
        graph.get("start").put("b",2);

        graph.put("a", new HashMap<String, Integer>());
        graph.get("a").put("fin",1);

        graph.put("b", new HashMap<String, Integer>());
        graph.get("b").put("a",3);
        graph.get("b").put("fin",5);

        graph.put("fin", new HashMap<String, Integer>());


        System.out.println("Самый короткий маршрут: " + String.valueOf(dijkstraAlgorithm(graph,"start","fin")));

    }


    /**
     * Метод с самим алгоритмом.<br>
     * Шаги алгоритма:<br>
     * 1. Найти точку с самым коротким маршрутом до неё и которая ещё не была обработана.<br>
     * 2. Обновить длину маршрута для всех её соседей.<br>
     * 3. Добавить точку в список обработанных.<br>
     * 4. Повторить цикл пока все точки не будут обработаны.<br>
     * <p>
     * @param graph - {@code HashMap<String, HashMap<String,Integer>>} граф у которого в качестве ключей вершины, а в качестве значений другие вершины и расстояния до них.
     * @param start - {@code String} название стартовой вершины.
     * @param fin {@code String} название конечной вершины.
     * @return длину самого короткого пути или 0 если такого нет.
     * */
    public static int dijkstraAlgorithm(HashMap<String, HashMap<String,Integer>> graph, String start, String fin){
        HashMap<String, Integer> costs = new HashMap<>(graph.get(start));
        costs.put(fin,null);

        HashMap<String, String> parents = new HashMap<>();
        for (String key: graph.get(start).keySet()){
            parents.put(key,start);
        }
        parents.put(fin,null);

        ArrayList<String> checked = new ArrayList<>();


        while (true){
            String node = findLowCostNode(costs,checked);
            if (node==null) break;

            Integer cost = costs.get(node);
            HashMap<String, Integer> neighbors = graph.get(node);

            for(String neighbor : neighbors.keySet()){
                int new_cost = neighbors.get(neighbor) + cost;
                if(costs.get(neighbor)==null || new_cost < costs.get(neighbor)){
                    costs.put(neighbor,new_cost);
                    parents.put(neighbor,node);
                }
            }
            checked.add(node);
        }

        System.out.println("graph: "+ graph);
        System.out.println("costs: "+ costs);
        System.out.println("parent: "+ parents);

        String node = fin;
        String path  = "Path: " + fin + " -> ";
        while (true){
            node = parents.get(node);
            if (node==null) break;
            path += node;
            if (node!= start) path += " -> ";

        }
        System.out.println(path);
        return costs.get(fin)!=null?costs.get(fin):0;

    }

    /**
     * Метод нахождения точки с самым коротким маршрутом которая ещё не была обработана.
     * @param costs - {@code HashMap<String, Integer>} хэш-таблица содержащая все вершины графа и расстояние до них.
     * @param  checked - {@code ArrayList<String>} список проверенных вершин
     * @return Самую близкую не проверенную вершину или null если такой нет.
     * */
    private static String findLowCostNode(HashMap<String, Integer> costs, ArrayList<String> checked){
        double min_value = (int) Double.POSITIVE_INFINITY;
        String min_node = null;

        for (Map.Entry<String, Integer> node : costs.entrySet()){
            if(node.getValue()!=null && !checked.contains(node.getKey()) && node.getValue()<min_value){
                min_node = node.getKey();
                min_value = node.getValue();
            }
        }

        return min_node;
    }
}
