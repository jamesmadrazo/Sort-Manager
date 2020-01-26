package com.sparta.james.engineering50.javabasic;


    import java.util.ArrayList;
    public class BinaryImplement implements InterfaceBinary {

        public BinaryImplement(int[] list) {
            addNodes(list);
        }

        private Element firstElement;

        @Override
        public Element getFirstElement() {
            return firstElement;
        }

        @Override
        public int getNumberOfNodes() {
            return Element.getNodeCounter();
        }

        @Override
        public void addNode(int set) {
            if (Element.getChildlessNode(firstElement, set).getValue() >= set) {
                Element.getChildlessNode(firstElement, set).setLeftChild(set);
            } else if (Element.getChildlessNode(firstElement, set).getValue() < set) {
                Element.getChildlessNode(firstElement, set).setRightChild(set);
            }
        }

        @Override
        public void addNodes(int[] set) {
            for (int i = 0; i < set.length; i++) {
                if (Element.getNodeCounter() == 0) {
                    this.firstElement = new Element(null, set[0]);
                } else {
                    addNode(set[i]);
                }
            }
        }

        @Override
        public boolean findNode(int set) {
            Element element = firstElement;
            while (true) {
                if (element == null) {
                    return false;
                } else if (element.getValue() == set) {
                    return true;
                } else {
                    if (element.getValue() >= set) {
                        element = element.getLeftChild();
                    } else if (element.getValue() <= set) {
                        element = element.getRightChild();
                    }
                }
            }
        }

        @Override
        public Element getLeftChild(Element element) {
            return element.getLeftChild();
        }

        @Override
        public Element getRightChild(Element element) {
            return element.getRightChild();
        }

        private ArrayList<Integer> sortedArray = new ArrayList<>();

        @Override
        public void createArrayInOrder(Element element) {
            if (element != null) {
                createArrayInOrder(element.getLeftChild());
                sortedArray.add(element.getValue());
                createArrayInOrder(element.getRightChild());
            }
        }

        @Override
        public int[] getSortedTreeAsc() {
            sortedArray.clear();
            createArrayInOrder(firstElement);
            int[] ascArray = new int[sortedArray.size()];
            for (int i = 0; i < sortedArray.size(); i++) {
                ascArray[i] = sortedArray.get(i);
            }
            return ascArray;
        }

        @Override
        public int[] getSortedTreeDesc() {
            sortedArray.clear();
            createArrayInOrder(firstElement);
            int[] descArray = new int[sortedArray.size()];
            for (int i = 0; i <= sortedArray.size() - 1; i++) {
                descArray[sortedArray.size() - 1 - i] = sortedArray.get(i);
            }
            return descArray;
        }
    }


