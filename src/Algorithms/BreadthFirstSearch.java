package Algorithms;

import java.util.*;



/**
 * @author Danil Kubarev
 * @version 1.0<br>
 * <div style="font-size:40px">BreadthFirstSearch(BFS)</div><br>
 * <div style="font-size:20px">Поиск в ширину</div><br>
 * Скорость выполнения O(V*E) V - Количество вершин. E - количество рёбер.<br>
 * Поиск в ширину позволяет определить, существует ли путь из A в B.<br>
 * Если путь существует, то поиск bfs находит кратчайший путь(по количеству шагов).<br>
 * Граф – это топологическая модель, которая состоит из множества вершин и множества соединяющих их рёбер.<br>
 * */
public class BreadthFirstSearch {
    /**
     * Стартовый метод, отсюда запускается программа и вызываются все остальные методы.
     * */
    public static void main(String[] args) {

        Trader me =  new Trader("me",null);
        Trader Vasya = new Trader("Vasya","tomato");
        Trader Petya = new Trader("Petya","mandarin");
        Trader Sasha = new Trader("Sasha","chess");
        Trader Kolya = new Trader("Kolya","bread");
        Trader Nastya = new Trader("Nastya", "candle");
        Trader Polina = new Trader("Polina","picture");
        Trader Oleg = new Trader("Oleg", "toy");
        Trader Natasha = new Trader("Natasha", "cake");


        HashMap<Trader, ArrayList<Trader>> graph_traders = new HashMap<>();
        graph_traders.put(me, new ArrayList<Trader>(Arrays.asList(new Trader[]{ Vasya, Petya, Sasha})));
        graph_traders.put(Vasya, new ArrayList<Trader>(Arrays.asList(new Trader[]{Petya, Kolya})));
        graph_traders.put(Petya, new ArrayList<Trader>(Arrays.asList(new Trader[]{Sasha, Nastya, Polina})));
        graph_traders.put(Kolya, new ArrayList<Trader>(Arrays.asList(new Trader[]{Petya, Oleg, Natasha})));
        graph_traders.put(Nastya, new ArrayList<Trader>(Arrays.asList(new Trader[]{ Oleg, Natasha, Polina})));
        System.out.println(breadthFirstSearch(me,graph_traders,"cake"));
    }


    /**
     * Метод поиска в ширину.<br>
     * На вход получает граф, стартовую точку графа и название продукта продавца которого нужно найти.<br>
     * <br>
     * Изначально в конец очереди добавляются все связи стартовой точки.
     * После в цикле пока очередь не будет пустой берётся первый элемент в очереди и проверяется, если этот продавец уже
     * проверялся, то цикл переходит на следующий шаг, иначе если продавец торгует нужным товаром, то return trader,
     * если нет, то продавец добавляется в список проверенных и в конец очереди добавляются все его связи.
     * Если очередь стала пустой, значит в грае нет нужного нам продавца и вернётся null.
     * @param start_trader {@code Trader} стартовая точка графа откуда пойдёт поиск.
     * @param graph_traders {@code HashMap<Trader, ArrayList<Trader>>} граф связей всех продавцов.
     * @param product_name {@code String} название продукта продавца которого нужно найти.
     * @return Продавца нужным товаром (Trader) или null
     * @see Trader
     * */
    public static Trader breadthFirstSearch(Trader start_trader, HashMap<Trader, ArrayList<Trader>> graph_traders, String product_name){

        Deque<Trader> graph = new ArrayDeque<>();
        for(Trader trader : graph_traders.get(start_trader)){
            graph.offerLast(trader);
        }

        ArrayList<Trader> checked = new ArrayList<>();

        while (true){
            Trader trader = graph.poll();
            if (trader == null) break;
            if (checked.contains(trader)) continue;
            if (trader.product_name.equals(product_name)) return trader;
            checked.add(trader);
            if(graph_traders.get(trader)==null) continue;
            for(Trader trader_friend : graph_traders.get(trader)){
                graph.offerLast(trader_friend);
            }
        }
        return null;
    }
}



