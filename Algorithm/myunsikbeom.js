/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
        var result = [];
        for(var i=0;i<nums.length;i++){
            var subst = target-nums[i];
            if(nums.indexOf(subst) > -1){
                result.push(i);
                result.push(nums.indexOf(subst));
                break;
            }
        }
        return result;
    };
