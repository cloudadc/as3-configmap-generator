#!/bin/bash

java -jar target/cis-perf.jar --count 5 --deploy 5-ns-deploy.yaml --ingress 5-ns-ingress.yaml --configmap 5-ns-configmap.yaml

read -p "Press enter to continue, or press Control + C to exit"

java -jar target/cis-perf.jar --count 10 --deploy 10-ns-deploy.yaml --ingress 10-ns-ingress.yaml --configmap 10-ns-configmap.yaml

java -jar target/cis-perf.jar --count 20 --deploy 20-ns-deploy.yaml --ingress 20-ns-ingress.yaml --configmap 20-ns-configmap.yaml

java -jar target/cis-perf.jar --count 30 --deploy 30-ns-deploy.yaml --ingress 30-ns-ingress.yaml --configmap 30-ns-configmap.yaml

java -jar target/cis-perf.jar --count 40 --deploy 40-ns-deploy.yaml --ingress 40-ns-ingress.yaml --configmap 40-ns-configmap.yaml

java -jar target/cis-perf.jar --count 50 --deploy 50-ns-deploy.yaml --ingress 50-ns-ingress.yaml --configmap 50-ns-configmap.yaml

java -jar target/cis-perf.jar --count 60 --deploy 60-ns-deploy.yaml --ingress 60-ns-ingress.yaml --configmap 60-ns-configmap.yaml

java -jar target/cis-perf.jar --count 70 --deploy 70-ns-deploy.yaml --ingress 70-ns-ingress.yaml --configmap 70-ns-configmap.yaml

java -jar target/cis-perf.jar --count 80 --deploy 80-ns-deploy.yaml --ingress 80-ns-ingress.yaml --configmap 80-ns-configmap.yaml

java -jar target/cis-perf.jar --count 90 --deploy 90-ns-deploy.yaml --ingress 90-ns-ingress.yaml --configmap 90-ns-configmap.yaml

java -jar target/cis-perf.jar --count 100 --deploy 100-ns-deploy.yaml --ingress 100-ns-ingress.yaml --configmap 100-ns-configmap.yaml

java -jar target/cis-perf.jar --count 120 --deploy 120-ns-deploy.yaml --ingress 120-ns-ingress.yaml --configmap 120-ns-configmap.yaml

java -jar target/cis-perf.jar --count 140 --deploy 140-ns-deploy.yaml --ingress 140-ns-ingress.yaml --configmap 140-ns-configmap.yaml

java -jar target/cis-perf.jar --count 160 --deploy 160-ns-deploy.yaml --ingress 160-ns-ingress.yaml --configmap 160-ns-configmap.yaml

java -jar target/cis-perf.jar --count 180 --deploy 180-ns-deploy.yaml --ingress 180-ns-ingress.yaml --configmap 180-ns-configmap.yaml

java -jar target/cis-perf.jar --count 200 --deploy 200-ns-deploy.yaml --ingress 200-ns-ingress.yaml --configmap 200-ns-configmap.yaml



