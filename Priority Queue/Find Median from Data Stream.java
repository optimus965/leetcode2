class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<Integer>((a, b) -> b - a);
        max = new PriorityQueue<Integer>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if (min.size() == 0) {
            min.add(num);
        } else {
            int value = min.peek();
            if (num > value) {
                max.add(num);
            } else {
                min.add(num);
            }
            if (min.size() >= max.size() + 2) {
                max.add(min.poll());
            } else {
                if (max.size() >= min.size() + 2) {
                    min.add(max.poll());
                }
            }
        }

    }

    public double findMedian() {
        int size1 = min.size();
        int size2 = max.size();
        if (size1 == 1 && size2 == 0) {
            return min.peek();
        }
        if (size1 == size2) {
            double value = min.peek() + max.peek();
            return value / 2;
        }
        int value1 = min.size();
        int value2 = max.size();
        if (value1 > value2) {
            return min.peek();
        }
        return max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
