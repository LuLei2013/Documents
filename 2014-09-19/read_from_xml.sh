content1=""
content2=""
content3=""

read_dom ()
{
    local IFS=\>
    read -d \< ENTITY CONTENT
}

while read_dom; do
	if [[ "${ENTITY}" == *"key"* ]]
		then 
			# use the content 
			echo ${ENTITY}
			echo ${CONTENT}
			if [[ "${ENTITY}" == *"key1"* ]]
				then 
					content1=${CONTENT}
			fi
			if [[ "${ENTITY}" == *"key2"* ]]
				then 
					content2=${CONTENT}
			fi
			if [[ "${ENTITY}" == *"key3"* ]]
				then 
					content3=${CONTENT}
			fi
	fi
done < "Test.xml"


echo
echo
echo "the first three contents are as following:"
echo ${content1}
echo ${content2}
echo ${content3}

echo $?

###########################################################################
#
#  This  script is used to read the xml and then parse it,
#  during the parse stage, it will read the content of the specialized 
#  key and set it to local variable  which will be used in the future.
#
###########################################################################