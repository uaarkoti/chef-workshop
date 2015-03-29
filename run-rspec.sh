for cbname in `find cookbooks -maxdepth 1 -mindepth 1 -type d` ; do rspec $cbname --format RspecJunitFormatter --out rspec_results/${cbname}-results.xml; done;
exit 0
