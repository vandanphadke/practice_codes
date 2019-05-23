package Amazon;

import java.util.ArrayList;

class CategoryNode{
    public int value;
    public ArrayList<CategoryNode> subCategories;

    public CategoryNode(){
        subCategories = new ArrayList<>();
    }

    public CategoryNode(int tenure){
        this.value = tenure;
        subCategories = new ArrayList<>();
    }
}

class CategoryCount {
    CategoryNode node;
    int sum;
    int count;

    public CategoryCount(CategoryNode node, int sum, int count){
        this.node = node;
        this.sum = sum;
        this.count = count;
    }
}
public class ComponentsMaxAvg {

    CategoryCount maxCount = null;

    public CategoryNode getMostPopularCategory(CategoryNode rootCategory){
        recurse(rootCategory);
        return maxCount.node;
    }

    public CategoryCount recurse(CategoryNode root) {

        //Base case
        if (root.subCategories.size() == 0) {
            return new CategoryCount(root, root.value, 1);
        }

        int childSum = root.value;
        int childCount = 1;

        for (CategoryNode child : root.subCategories) {
            CategoryCount current = recurse(child);
            childSum += current.sum;
            childCount += current.count;
        }
        float myAverage = (float) childSum / childCount;

        CategoryCount myCount = new CategoryCount(root, childSum, childCount);

        if (maxCount == null) {
            maxCount = myCount;
        } else {
            float globalAverage = (float) maxCount.sum / maxCount.count;
            if (myAverage > globalAverage) {
                maxCount = myCount;
            }
        }
        return myCount;
    }

}
