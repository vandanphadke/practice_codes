package BinarySearch;

import java.util.ArrayList;

/**
 * N number of books are given.
 * The ith book has Pi number of pages.
 * You have to allocate books to M number of students so that maximum
 * number of pages alloted to a student is minimum. A book will be
 * allocated to exactly one student. Each student has to be allocated
 * at least one book. Allotment should be in contiguous order,
 *
 * for example: A student cannot be allocated book 1 and book 3, skipping book 2.
 *
 * NOTE: Return -1 if a valid assignment is not possible
 *
 * Input:
 *
 * List of Books
 * M number of students
 * Your function should return an integer corresponding to the minimum number.
 *
 * Example:
 *
 * P : [12, 34, 67, 90]
 * M : 2
 *
 * Output : 113
 *
 * There are 2 number of students. Books can be distributed in following fashion :
 *   1) [12] and [34, 67, 90]
 *       Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
 *   2) [12, 34] and [67, 90]
 *       Max number of pages is allocated to student 2 with 67 + 90 = 157 pages
 *   3) [12, 34, 67] and [90]
 *       Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
 *
 * Of the 3 cases, Option 3 has the minimum pages = 113.
 */
public class AllocateBooks {

    public static int getMinimumPages(ArrayList<Integer> books, int numStudents){
        int n = books.size();

        if (n < numStudents) return -1;
        long finalResult = Integer.MAX_VALUE;

        long sum = 0;
        for (int book: books) sum += book;

        long minPages = 0, maxPages = sum;

        while (minPages <= maxPages){
            long midPages = minPages + ((maxPages - minPages)/2);
            if (checkPossible(books, numStudents, midPages)){
                finalResult = Math.min(finalResult, midPages);
                maxPages = midPages - 1;
            }
            else {
                minPages = midPages + 1;
            }
        }
        return (int)finalResult;
    }

    public static boolean checkPossible(ArrayList<Integer> books, int numStudents, long currentPages){
        int current = 1, pages = 0;

        for (int i = 0; i < books.size(); ++i){
            if (books.get(i) > currentPages)
                return false;

            pages += books.get(i);

            if (pages > currentPages){
                ++current;
                pages = books.get(i);
            }

            if (current > numStudents) return false;
        }
        return true;
    }

}
