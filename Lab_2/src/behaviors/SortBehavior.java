package behaviors;

import abstractions.ISort;

/**
 * Context for strategy
 */
public class SortBehavior {

    private ISort sort;

    public SortBehavior(ISort sort){
        this.sort = sort;
    }

    public int [] executeSort (int [] array){
        return sort.sort(array);
    }
}
