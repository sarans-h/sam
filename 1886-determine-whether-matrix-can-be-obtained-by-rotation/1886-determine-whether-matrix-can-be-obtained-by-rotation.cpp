class Solution {
public:
    vector<vector<int>> rotate90(vector<vector<int>>& mat) {
        int n = mat.size();
        vector<vector<int>> res(n, vector<int>(n));

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                res[j][n - i - 1] = mat[i][j];
            }
        }
        return res;
    }

    bool findRotation(vector<vector<int>>& mat, vector<vector<int>>& target) {
        for(int i = 0; i < 4; i++){
            if(mat == target) return true;
            mat = rotate90(mat);
        }
        return false;
    }
};