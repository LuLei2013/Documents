!bin/bash

read_dom ()
{
    local IFS=\>
    read -d \< ENTITY CONTENT
}

while read_dom; do
	if [[ "${ENTITY}" == *"key"* ]]
		then 
			echo ${CONTENT}
	fi
done < "Test.xml"