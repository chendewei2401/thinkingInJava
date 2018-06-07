#!/bin/bash
#folder="./test"

function readfile ()
{
#这里`为esc下面的按键符号
  for file in `ls .`
  do
    if [ -d $file ]
    then
        continue
    fi
    result=`cat $file | cut -d '|' -f15 | cut -d ' ' -f1 | sort | uniq | wc -l`

    if [[ $result != "1" ]]
    then
        echo $file
        echo $result
        echo -------
    fi
  done
}
#函数定义结束，这里用来运行函数
folder="."
readfile $folder
