#!/usr/bin/env bash

# exit when any command fails
set -e


owner="ons"
network="isolated"
url="https://api.algpoc.com/v1/algorithms" #ons
#url="https://api.algorithmia.com/v1/algorithms" #public

while getopts "a:k:l:n:o:u:" option; do
    case "${option}" in
    a) algorithm=${OPTARG};;
    c) conciseAlgorithmName=${OPTARG};;
    k) authKey=${OPTARG};;
    l) language=${OPTARG};;
    n) network=${OPTARG};;
    o) owner=${OPTARG};;
    u) url=${OPTARG};;
    *) echo "script usage: $(basename "$0") [-a algorithm name] [-k auth key] [-l language (java, python3-1, scala)] [-n network_access (isolated, full)] [-o owner] [-u Algorithmia management api url]" >&2
       exit 1;;
    esac
done

#conciseAlgorithmName=${algorithm//[^[:alnum:]]/}

echo "Creating algorithm '${algorithm}' with name '${conciseAlgorithmName}'..."
echo

curl --location --request POST "${url}/${owner}" \
  --header "Authorization: Simple ${authKey}" \
  --header "Content-Type: application/json" \
  --data "{
    \"details\": {
        \"summary\": \"\",
        \"label\": \"${algorithm}\",
        \"tagline\": \"\"
    },
    \"name\": \"${conciseAlgorithmName}\",
    \"settings\": {
        \"license\": \"mit\",
        \"network_access\": \"${network}\",
        \"pipeline_enabled\": false,
        \"source_visibility\": \"open\",
        \"language\": \"${language}\",
        \"environment\": \"cpu\",
        \"royalty_microcredits\": 0
    },
    \"version_info\": {
        \"sample_input\": \"\"
    }
}"