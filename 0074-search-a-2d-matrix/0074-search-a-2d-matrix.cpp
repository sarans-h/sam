    class Solution {
    public:
        bool searchMatrix(vector<vector<int>>& matrix, int target) {
            int m=matrix.size();
            int n=matrix[0].size();
            int low=0;
            int high=n*m-1;
            while(low<=high){
                int mid = low+(high-low)/2;
                int i = mid / n;   // row
                int j = mid % n;   // column
                if (matrix[i][j] == target) return true;
                else if (matrix[i][j] < target) low = mid + 1;
                else high = mid - 1;
            }
            return false;
        }
    };