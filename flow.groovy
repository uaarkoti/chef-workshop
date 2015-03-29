node('master') {
  sh 'rm -rf chefconf-2015'
  stage 'Dev'
  dir('chefconf-2015') {
    git 'https://github.com/uaarkoti/chef-workshop.git'
    stage 'unit'

    sh './chef-ci-tools/bin/chef-foodcritic-publisher.sh -X spec -f any -t "~FC003"'
    step([$class: 'JUnitResultArchiver', testResults: 'junit_reports/foodcritic-*.xml'])
    
    sh 'run-rspec.sh'
    step([$class: 'JUnitResultArchiver', testResults: 'rspec_results/*/*.xml'])
  }
}
