TOC_HW3
=======

Theory of Computation hw3

Arguments:

1. URL, such as http://www.datagarage.io/api/5365dee31bc6e9d9463a0057

2. 鄉鎮市區: Specify the name in the column ‘鄉鎮市區’. For example, “文山區”.

3. Road_Name: Specify the road name in the column ‘土地區段位置或建物區門牌’. For
   example, “中壢市環西路”means we would like to check 中壢市環西路x段 or 中壢市環西
   路x巷 or any road name containing 中壢市環西路.

4. Year: Specify the “year” in the column ‘交易年月’. You should retrieve all houses sold at/after
the “Year”.


Running Examples 1:

Input: java –jar TocHW3.jar http://www.datagarage.io/api/5365dee31bc6e9d9463a0057 文山區 辛亥路 103

Output:
17600000
